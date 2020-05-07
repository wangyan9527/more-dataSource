package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sal.excel.ExcelService;
import web.dto.Result;
import web.dto.ResultUtils;
import web.dto.StartAndEndIdDto;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    ExcelService excelService;

    @RequestMapping("/doAndInsertFeedback.json")
    public Result saveGoods(@RequestBody StartAndEndIdDto dto) {
        excelService.doAndInsertFeedback(dto.getStartId(), dto.getEndId());
        return ResultUtils.buildResult();
    }

    @RequestMapping("/doAndInsertExcel.json")
    public Result doAndInsertExcel(@RequestBody StartAndEndIdDto dto) {
        excelService.doAndInsertExcel(dto.getStartId(), dto.getEndId());
        return ResultUtils.buildResult();
    }

    @RequestMapping("/doAndInsertFeedback1.json")
    public Result doAndInsertFeedback1(@RequestBody StartAndEndIdDto dto) {
        excelService.doAndInsertFeedback1(dto.getStartId(), dto.getEndId());
        return ResultUtils.buildResult();
    }

    @RequestMapping("/doAndGetTeacherNo.json")
    public Result doAndGetTeacherNo(@RequestBody StartAndEndIdDto dto) {
        excelService.doAndGetTeacherNo(dto.getStartId(), dto.getEndId());
        return ResultUtils.buildResult();
    }

    @RequestMapping("/buildTeacherScoreRatio.json")
    public Result buildTeacherScoreRatio(@RequestBody StartAndEndIdDto dto) {
        excelService.buildTeacherScoreRatio(dto.getStartId(), dto.getEndId());
        return ResultUtils.buildResult();
    }

}
