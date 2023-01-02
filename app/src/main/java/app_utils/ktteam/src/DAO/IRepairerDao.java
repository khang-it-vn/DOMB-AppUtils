package app_utils.ktteam.src.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

import app_utils.ktteam.src.Entities.ERepaierDistance;

@Dao
public interface IRepairerDao {

    @Insert
    void insertRepairer(ERepaierDistance repaierDistance);

    @Query("select * from Repairer")
    List<ERepaierDistance> getAll();
}
