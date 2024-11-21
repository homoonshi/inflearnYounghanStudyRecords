package hello.itemservice.message;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest
public class MessageSourceTest {

  @Autowired
  MessageSource ms;

  @Test
  void debugHelloMessage() {
    System.out.println(ms.getMessage("hello", null, null));
  }

  @Test
  void helloMessage() {
    String result = ms.getMessage("hello", null, null);
    assertThat(result).isEqualTo("안녕");
  }

}
