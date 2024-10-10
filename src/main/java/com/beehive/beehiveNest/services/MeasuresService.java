package com.beehive.beehiveNest.services;

import com.beehive.beehiveNest.exceptions.DependencyNotFoundException;
import com.beehive.beehiveNest.model.dtos.MeasureDto;
import com.beehive.beehiveNest.model.entities.Beehive;
import com.beehive.beehiveNest.model.entities.Measure;
import com.beehive.beehiveNest.model.forms.MeasureForm;
import com.beehive.beehiveNest.model.mappers.MeasuresMapper;
import com.beehive.beehiveNest.repository.BeehivesRepository;
import com.beehive.beehiveNest.repository.MeasuresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasuresService implements CrudService<MeasureDto, MeasureForm> {

    @Autowired
    private MeasuresMapper measuresMapper;
    @Autowired
    private MeasuresRepository measuresRepository;
    @Autowired
    private BeehivesRepository beehivesRepository;

    @Override
    public List<MeasureDto> getAll() {
        return measuresRepository.findAll().stream()
                .map(measuresMapper::getDto)
                .toList();
    }

    @Override
    public Optional<MeasureDto> getById(Long id) {
        return measuresRepository.findById(id)
                .map(measuresMapper::getDto);
    }

    @Override
    public MeasureDto create(MeasureForm form) {
        Measure entity = measuresMapper.getEntity(form);

        Beehive beehive = beehivesRepository.findById(form.getBeehiveId())
                .orElseThrow(() -> new DependencyNotFoundException("Beehive with ID " + form.getBeehiveId() + " not found."));
        entity.setBeehive(beehive);

        Measure savedEntity = measuresRepository.save(entity);
        return measuresMapper.getDto(savedEntity);
    }

    @Override
    public Optional<MeasureDto> update(Long id, MeasureForm form) {
        if (!measuresRepository.existsById(id)) {
            return Optional.empty();
        }
        Measure entity = measuresMapper.getEntity(form);

        Beehive beehive = beehivesRepository.findById(form.getBeehiveId())
                .orElseThrow(() -> new DependencyNotFoundException("Beehive with ID " + form.getBeehiveId() + " not found."));
        entity.setBeehive(beehive);

        entity.setId(id);
        Measure updatedEntity = measuresRepository.save(entity);
        return Optional.of(measuresMapper.getDto(updatedEntity));
    }

    @Override
    public boolean delete(Long id) {
        if (!measuresRepository.existsById(id)) {
            return false;
        }
        measuresRepository.deleteById(id);
        return true;
    }
}
