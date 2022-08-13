package usingMapSet;

import java.util.*;

public class OpenChat {
    HashMap<String, User> map = new HashMap<>();
    static final String ENTER_STR = "%s님이 들어왔습니다.";
    static final String LEAVE_STR = "%s님이 나갔습니다.";

    private class User {
        String id;
        String name;

        User (String id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    private class Command {
        String state;
        String id;

        Command(String state, String id) {
            this.state = state;
            this.id = id;
        }
    }

    public String[] solution(String[] records) {
        ArrayList<Command> ans = new ArrayList<>();

        for (String record : records) {
            String[] rec = record.split(" ");
            String state = rec[0];
            String id = rec[1];

            switch (state) {
                case "Enter":
                    String name = rec[2];
                    if (!map.containsKey(id)) map.put(id, new User(id, name));
                    else map.get(id).name = name;
                    ans.add(new Command(state, id));
                    break;
                case "Leave":
                    ans.add(new Command(state, id));
                    break;
                case "Change":
                    name = rec[2];
                    map.get(id).name = name;
                default:
                    break;
            }

        }

        return ans.stream().map(c -> String.format(c.state.equals("Enter") ? ENTER_STR : LEAVE_STR, map.get(c.id).name)).toArray(arr -> new String[ans.size()]);
    }
}
