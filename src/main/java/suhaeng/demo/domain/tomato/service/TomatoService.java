package suhaeng.demo.domain.tomato.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import suhaeng.demo.domain.tomato.dto.request.UpdateTomatoRequest;
import suhaeng.demo.domain.tomato.entity.Tomato;
import suhaeng.demo.domain.tomato.exception.TomatoStatusCode;
import suhaeng.demo.domain.tomato.repository.TomatoRepository;
import suhaeng.demo.global.common.ApiResponse;
import suhaeng.demo.global.exception.ApplicationException;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class TomatoService {
    private final TomatoRepository tomatoRepository;


    public ApiResponse<Boolean> updateTomato(Long id, UpdateTomatoRequest request) {
        Tomato tomato = tomatoRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(TomatoStatusCode.TOMATO_NOT_FOUND));
        tomato.updateTomato(request);
        return ApiResponse.ok(Boolean.TRUE, "일지가 업데이트 됐습니다.");
    }

    public void updatePruningStatus(Long id, boolean pruned) {
        Tomato tomato = tomatoRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(TomatoStatusCode.TOMATO_NOT_FOUND));

        tomato.updatePruned(pruned);
    }

    public void deleteTomato(Long id) {
        Tomato tomato = tomatoRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(TomatoStatusCode.TOMATO_NOT_FOUND));
        tomatoRepository.delete(tomato);
    }
}
