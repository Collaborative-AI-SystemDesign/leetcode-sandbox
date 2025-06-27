package com.example.demo.problem;

import static com.example.demo.submission.SubmissionStatus.PENDING;
import static com.example.demo.submission.SubmissionStatus.SUCCESS;

import com.example.demo.problem.message.dto.SubmissionRequest;
import com.example.demo.problem.message.dto.SubmissionResult;
import org.springframework.stereotype.Service;

@Service
public class SubmissionProcessor {

    public SubmissionResult processSubmission(SubmissionRequest request) {
        Long submissionId = request.getSubmissionId();
        Long contestId = request.getContestId();
        try {
            busyWait(2L);
            return new SubmissionResult(
                    submissionId,
                    contestId,
                    SUCCESS
            );
        } catch (Exception e) {
            return new SubmissionResult(
                    submissionId,
                    contestId,
                    PENDING
            );
        }
    }

    private void executeJavaCode(SubmissionRequest request) throws InterruptedException {
        // 실제로는 Docker 컨테이너나 샌드박스 환경에서 실행
        // 시뮬레이션: 실제 코드 실행
        Thread.sleep(2000);
    }

    public static void busyWait(long seconds) {
        // 1초는 1,000,000,000 나노초입니다.
        long durationInNanos = seconds * 1_000_000_000L;
        long startTime = System.nanoTime();

        // 현재 시간이 시작 시간 + 대기 시간보다 작을 동안 루프를 계속 실행합니다.
        while ((System.nanoTime() - startTime) < durationInNanos) {
            // 이 루프를 계속해서 돌면서 CPU를 점유합니다.
            // 안에는 아무런 코드도 실행할 필요가 없습니다.
        }
    }
}
