import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void testCreate() throws IOException {

        // 기본형
        IntStream intStream = IntStream.range(1, 5);
        LongStream longStream = LongStream.range(1, 5);

        // 제네릭 (오토박싱)
        Stream<Integer> integerStream = IntStream.range(1,5).boxed();

        // 배열
        Integer[] arr = new Integer[]{1,2,3,4,5};
        Stream<Integer> integerStream2 = Stream.of(arr);
        Stream<Integer> integerStream3 = Arrays.stream(arr);
        Stream<Integer> integerStream4 = Arrays.stream(arr, 1, 3);

        // 콜렉션
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> integerStream5 = list.stream();

        // 병렬처리
        Stream<Integer> parallelStream = list.parallelStream();

        // 빈스트림
        Stream<Integer> emptyStream = Stream.empty();

        // 빌더
        Stream<Integer> builtStream = Stream.<Integer>builder().add(1).add(2).add(3).build();

        // 람다
        Stream<Integer> generatedStream = Stream.generate(() -> 1).limit(5);
        Stream<Double> generatedStream2 = Stream.generate(Math::random).limit(5);
        Stream<Integer> iteratedStream = Stream.iterate(10, n -> n*2).limit(5);

        // 파일
        Stream<String> stream = Files.lines(Paths.get("file.txt"), Charset.forName("UTF-8"));
    }

    @Test
    public void testStreamMethod() {
        Stream<Integer> integerStream = Stream.concat(
                Stream.of(1,2,3,4),
                Stream.of(5,6,7,8)
        );

        integerStream.filter(n -> n%2 == 0).forEach(System.out::println);
    }


}
