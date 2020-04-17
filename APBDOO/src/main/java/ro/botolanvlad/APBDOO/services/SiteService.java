package ro.botolanvlad.APBDOO.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.botolanvlad.APBDOO.mappers.LocationMapper;
import ro.botolanvlad.APBDOO.mappers.SiteMapper;
import ro.botolanvlad.APBDOO.models.LocationModel;
import ro.botolanvlad.APBDOO.models.SiteModel;
import ro.botolanvlad.APBDOO.repositories.SiteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SiteService {

    @NonNull
    private SiteRepository siteRepository;

    @Transactional(readOnly = true)
    public List<SiteModel> getSites() {
        return siteRepository.findAll().stream()
                .map(SiteMapper::toModel)
                .collect(Collectors.toList());
    }
}
