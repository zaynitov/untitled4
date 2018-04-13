package ses;


import jg.NotesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class NotesDaoImpl implements NotesDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public NotesEntity getNotesbyID(long id) {

        Session session = this.sessionFactory.getCurrentSession();


        session.beginTransaction();
        NotesEntity p = (NotesEntity) session.load(NotesEntity.class, id);
        return p;
    }


}
