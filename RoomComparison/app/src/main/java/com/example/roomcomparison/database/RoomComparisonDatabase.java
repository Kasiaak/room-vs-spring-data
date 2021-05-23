package com.example.roomcomparison.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.roomcomparison.dao.MatchDao;
import com.example.roomcomparison.dao.MatchWithPlayersDao;
import com.example.roomcomparison.dao.PlayerDao;
import com.example.roomcomparison.dao.TournamentDao;
import com.example.roomcomparison.dao.TournamentWithMatchesDao;
import com.example.roomcomparison.dao.TournamentWithPlayersDao;
import com.example.roomcomparison.entity.match.MatchEntity;
import com.example.roomcomparison.entity.player.Player;
import com.example.roomcomparison.entity.tournament.Tournament;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Player.class, MatchEntity.class, Tournament.class}, version = 1, exportSchema = false)
public abstract class RoomComparisonDatabase  extends RoomDatabase {

    public abstract PlayerDao playerTournamentProfileDao();
    public abstract MatchDao matchDao();
    public abstract MatchWithPlayersDao matchWithPlayersDao();
    public abstract TournamentDao tournamentDao();
    public abstract TournamentWithPlayersDao tournamentWithPlayersDao();
    public abstract TournamentWithMatchesDao tournamentWithMatchesDao();

    private static volatile RoomComparisonDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static RoomComparisonDatabase getDatabase(final Context context) {
        if(INSTANCE == null) {
            synchronized (RoomComparisonDatabase.class) {
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), RoomComparisonDatabase.class, "room_comparison_db")
                            .addCallback(sRoomComparisonDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomComparisonDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                PlayerDao playerDao = INSTANCE.playerTournamentProfileDao();
                MatchDao matchDao = INSTANCE.matchDao();
                TournamentDao tournamentDao = INSTANCE.tournamentDao();
                TournamentWithPlayersDao tournamentWithPlayersDao = INSTANCE.tournamentWithPlayersDao();
                TournamentWithMatchesDao tournamentWithMatchesDao = INSTANCE.tournamentWithMatchesDao();
                MatchWithPlayersDao matchWithPlayersDao = INSTANCE.matchWithPlayersDao();

                playerDao.deleteAllPlayers();
                matchDao.deleteAllMatches();
                tournamentDao.deleteAllTournaments();
            });
        }
    };
}
