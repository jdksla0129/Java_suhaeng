package suhaeng.demo.domain.tomato.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import suhaeng.demo.domain.tomato.dto.request.UpdateTomatoRequest;
import suhaeng.demo.domain.tomato.dto.request.CreateTomatoRequest;
import suhaeng.demo.domain.tomato.dto.response.TomatoRecordResponse;
import suhaeng.demo.domain.tomato.entity.Tomato;
import suhaeng.demo.domain.tomato.exception.TomatoStatusCode;
import suhaeng.demo.domain.tomato.repository.TomatoRepository;
import suhaeng.demo.global.common.ApiResponse;
import suhaeng.demo.global.exception.ApplicationException;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class TomatoService {
    private final TomatoRepository tomatoRepository;

    @Transactional(readOnly = true)
    public ApiResponse<List<TomatoRecordResponse>> getTomatoRecord() {
        List<TomatoRecordResponse> response = tomatoRepository.findAll()
                .stream()
                .map(TomatoRecordResponse::from)
                .toList();

        return ApiResponse.ok(
                response,
                "토마토 기록지를 불러오는데 성공하셨습니다!"
        );
    }

    public ApiResponse<TomatoRecordResponse> createTomatoState(CreateTomatoRequest request) {
        Tomato tomato = Tomato.builder()
                .date(request.date())
                .build();

        tomatoRepository.save(tomato);

        return ApiResponse.ok(
                TomatoRecordResponse.from(tomato),
                "오늘의 토마토 상태를 기록하셨습니다!"
        );
    }

    public ApiResponse<Boolean> updateTomato(Long id, UpdateTomatoRequest request) {
        Tomato tomato = tomatoRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(TomatoStatusCode.TOMATO_NOT_FOUND));
        tomato.updateTomato(request);

        return ApiResponse.ok(
                Boolean.TRUE,
                "일지가 업데이트 됐습니다."
        );
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
