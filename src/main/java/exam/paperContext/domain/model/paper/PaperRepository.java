package exam.paperContext.domain.model.paper;

public interface PaperRepository {
  void save(Paper paper);

  Paper get(String id);
}
