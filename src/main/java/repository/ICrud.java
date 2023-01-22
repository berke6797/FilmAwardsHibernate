package repository;

public interface ICrud <T>{
    void save(T t);
    void getAll();
    void update(T t);
    void delete (int id);

}
