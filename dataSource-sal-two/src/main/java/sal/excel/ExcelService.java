package sal.excel;

public interface ExcelService {

    void doAndInsertFeedback(Long startFeedbackId, Long endFeedbackId);

    void doAndInsertExcel(Long startId, Long endId);

    void checkTeacher();

    void checkStageId();

    void doAndInsertFeedback1(Long startId, Long endId);


    void doAndGetTeacherNo(Long startId, Long endId);

    void buildTeacherScoreRatio(Long startId, Long endId);

}
