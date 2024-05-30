package com.example.rankboard.interfaces;

import com.example.rankboard.application.RankBoardFacade;
import com.example.rankboard.common.response.CommonResponse;
import com.example.rankboard.domain.ScoreInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/scores")
public class RankBoardApi {
    private final RankBoardFacade rankBoardFacade;

    @PostMapping
    public CommonResponse<ScoreDto.ResponsePoint> updateScore(@RequestBody ScoreDto.RequestPoint requestPoint) {
        ScoreInfo scoreInfo = rankBoardFacade.updateScore(requestPoint.getUserId(), requestPoint.getPoint());
        return CommonResponse.success(null);
    }

    @GetMapping
    public CommonResponse<List<ScoreDto.ResponsePoint>> getTop10Players() {
        return CommonResponse.success(null);
    }

    @GetMapping("{userId}")
    public CommonResponse<ScoreDto.ResponsePoint> getUserDetail(@PathVariable String userId) {
        return CommonResponse.success(null);
    }

}
