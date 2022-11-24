package vn.codegym.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class StudentRepositoryImpl implements IStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager
                .createQuery("select s from Student as s", Student.class);
        return query.getResultList();
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student); //thêm mới
//        entityManager.merge(student); //cập nhật
//        entityManager.remove(student); //xóa
//        entityManager.find(Student.class, 5); //tìm kiếm với id = 5
    }
}
