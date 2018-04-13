package ses;

import jg.NotesEntity;

import java.sql.SQLException;

public interface NotesDao {
    public NotesEntity getNotesbyID(long id);

}
