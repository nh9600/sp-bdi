package test.test3;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("food")
@Data
public class Food {
	private String name;
	private Integer price;

}
