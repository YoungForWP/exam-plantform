package exam.examinationContext.domain.model.examination;

public interface ExaminationRepository {
  void save(Examination examination);

  Examination get(String id);
}
