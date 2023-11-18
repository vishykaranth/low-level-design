package event_calendar.sss.mcoding.dao;

import event_calendar.sss.mcoding.models.Team;

import java.util.HashMap;
import java.util.Map;

public class TeamDao {
    private Map<String, Team> teamMap;

    public TeamDao() {
        teamMap = new HashMap<>();
    }

    public void createTeam(Team team) {
        if (teamMap.containsKey(team.getName())) {
            throw new RuntimeException("Team exists with same name " + team.getName());
        }
        teamMap.put(team.getName(), team);
    }

    public Team getTeam(String teamName) {
        if (!teamMap.containsKey(teamName)) {
            throw new RuntimeException("Team not found with name " + teamName);
        }
        return teamMap.get(teamName);
    }
}
