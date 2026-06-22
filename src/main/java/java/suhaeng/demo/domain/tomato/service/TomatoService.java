package java.suhaeng.demo.domain.tomato.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.suhaeng.demo.domain.tomato.entity.Tomato;
import java.suhaeng.demo.domain.tomato.exception.TomatoStatusCode;
import java.suhaeng.demo.domain.tomato.repository.TomatoRepository;
import java.suhaeng.demo.global.exception.ApplicationException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TomatoService {

    private final TomatoRepository tomatoRepository;

    @Transactional
    public void deleteTomato(Long id) {
        Tomato tomato = tomatoRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(TomatoStatusCode.TOMATO_NOT_FOUND));
        tomatoRepository.delete(tomato);
    }

    @Transactional
    public void updatePruningStatus(Long id, boolean pruned) {
        Tomato tomato = tomatoRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(TomatoStatusCode.TOMATO_NOT_FOUND));
        tomato.updatePruned(pruned);
    }
}