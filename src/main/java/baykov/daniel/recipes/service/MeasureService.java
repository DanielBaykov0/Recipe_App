package baykov.daniel.recipes.service;

import baykov.daniel.recipes.entity.Measure;
import baykov.daniel.recipes.exception.EntityAlreadyExistsException;
import baykov.daniel.recipes.exception.ResourceNotFoundException;
import baykov.daniel.recipes.payload.GenericPageableResponse;
import baykov.daniel.recipes.payload.response.ResponseMessage;
import baykov.daniel.recipes.repository.MeasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeasureService {

    private final MeasureRepository measureRepository;

    public Measure findMeasureById(Long id) {
        return measureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public GenericPageableResponse<Measure> findAllMeasuresPaged(
            int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Measure> measures = measureRepository.findAll(pageable);
        return new GenericPageableResponse<>(measures, measures.stream().toList());
    }

    public Measure addNewMeasure(String name) {
        Measure measure = measureRepository.findByName(name)
                .orElseThrow(() -> new EntityAlreadyExistsException(name));
        return measureRepository.save(measure);
    }

    public ResponseMessage updateMeasureById(Long measureId, Measure measure) {
        Measure existingMeasure = measureRepository.findById(measureId)
                .orElseThrow(() -> new ResourceNotFoundException(measureId));

        if (existingMeasure.getName().name().equalsIgnoreCase(measure.getName().name())) {
            throw new EntityAlreadyExistsException(measure.getName().name());
        }

        existingMeasure.setName(measure.getName());
        measureRepository.save(existingMeasure);
        return new ResponseMessage();
    }

    public void deleteMeasureById(Long id) {
        Measure measure = measureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        measureRepository.deleteById(measure.getId());
    }
}
