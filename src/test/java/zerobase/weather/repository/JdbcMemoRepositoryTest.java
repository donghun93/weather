package zerobase.weather.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class JdbcMemoRepositoryTest {

    @Autowired
    private JdbcMemoRepository jdbcMemoRepository;

    @Test
    @DisplayName("메모 생성 테스트")
    void memoInsertTest() {
        // given
        Memo memo = new Memo(1, "테스트");

        // when
        Memo savedMemo = jdbcMemoRepository.save(memo);

        // then
        assertThat(savedMemo.getId()).isEqualTo(1);
        assertThat(savedMemo.getText()).isEqualTo("테스트");
    }

    @Test
    @DisplayName("메모 리스트 조회 테스트")
    void findAllMemoTest() {
        // given
        Memo memo1 = new Memo(1, "테스트1");
        Memo memo2 = new Memo(2, "테스트2");
        Memo memo3 = new Memo(3, "테스트3");

        jdbcMemoRepository.save(memo1);
        jdbcMemoRepository.save(memo2);
        jdbcMemoRepository.save(memo3);

        // when
        List<Memo> list = jdbcMemoRepository.findAll();

        // then
        assertThat(list.size()).isEqualTo(3);
    }


}