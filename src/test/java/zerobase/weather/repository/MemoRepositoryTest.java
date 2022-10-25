package zerobase.weather.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles({"test"})
class MemoRepositoryTest {

    @Autowired
    private MemoRepository memoRepository;

    @Test
    @DisplayName("메모 생성 테스트")
    void memoInsertTest() {
        // given
        Memo memo = new Memo("테스트");

        // when
        Memo savedMemo = memoRepository.save(memo);

        // then
        assertThat(savedMemo.getText()).isEqualTo("테스트");
    }

    @Test
    @DisplayName("메모 리스트 조회 테스트")
    void findAllMemoTest() {
        // given
        Memo memo1 = new Memo( "테스트1");
        Memo memo2 = new Memo( "테스트2");
        Memo memo3 = new Memo( "테스트3");

        memoRepository.save(memo1);
        memoRepository.save(memo2);
        memoRepository.save(memo3);

        // when
        List<Memo> list = memoRepository.findAll();

        // then
        assertThat(list.size()).isEqualTo(3);
    }

}