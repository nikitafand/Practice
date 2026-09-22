package coding.dsa;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamToMapList
{
    public static void main(String[] args)
    {
        List<Note> listNotes = List.of(new Note(1, "note1", 11),
                new Note(2,"note2", 22),
                new Note(3,"note3", 22),
                new Note(4,"note4", 22),
                new Note(5,"note5", 22),
                new Note(6,"note4", 22)

        ) ;
        Map<String, Note> collect = listNotes.stream().sorted(Comparator.comparing(Note::id))
                .collect(Collectors.toMap(Note::description, e -> e,
                        (existing, newer) -> existing)

                );

        collect.forEach((k,v)->{
            System.out.println(k +"v::" + v);
        });
    }
}
record Note(int id, String description, int deptId){

}