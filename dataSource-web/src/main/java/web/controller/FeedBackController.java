package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sal.feedback.FeedbackService;
import web.dto.IdDto;
import web.dto.Result;
import web.dto.ResultUtils;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping("/getById.json")
    public Result saveGoods(@RequestBody IdDto reqDto) {
        return ResultUtils.buildResult(feedbackService.queryById(reqDto.getId()));
    }

}
