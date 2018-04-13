package ses;

import jg.NotesEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application {
    private static ServiceRegistry serviceRegistry;
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        NotesDaoImpl notesDao = new NotesDaoImpl();

        Configuration configuration = new Configuration().configure();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        notesDao.setSessionFactory(sessionFactory);


        NotesEntity notesbyID = notesDao.getNotesbyID(1);
        System.out.println(notesbyID.getContent());

    }
}
