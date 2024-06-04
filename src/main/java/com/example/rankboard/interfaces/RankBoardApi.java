package com.example.rankboard.interfaces;

import com.example.rankboard.application.RankBoardFacade;
import com.example.rankboard.common.response.CommonResponse;
import com.example.rankboard.domain.ScoreInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/scores")
public class RankBoardApi {
    private final RankBoardFacade rankBoardFacade;

    @PostMapping
    public CommonResponse<ScoreDto.ResponsePoint> updateScore(@RequestBody ScoreDto.RequestPoint requestPoint) {
        ScoreInfo scoreInfo = rankBoardFacade.updateScore(requestPoint.getUserId(), requestPoint.getPoint());
        return CommonResponse.success(ScoreDto.ResponsePoint.byInfo(scoreInfo));
    }

    @GetMapping
    public CommonResponse<List<ScoreDto.ResponsePoint>> getTop10Players() {
        List<ScoreInfo> top10Player = rankBoardFacade.getTop10Player();
        List<ScoreDto.ResponsePoint> responseList = top10Player.stream().map(ScoreDto.ResponsePoint::byInfo)
                .toList();
        return CommonResponse.success(responseList);
    }

    @GetMapping("{userId}")
    public CommonResponse<ScoreDto.ResponsePoint> getUserDetail(@PathVariable String userId) {
        ScoreInfo score = rankBoardFacade.getScore(userId);
        return CommonResponse.success(ScoreDto.ResponsePoint.byInfo(score));
    }

}
