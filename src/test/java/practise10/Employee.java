package practise10;

import lombok.Setter;

import java.util.List;

public record Employee(String name, int age, String sex, List<String> devices) {
}
