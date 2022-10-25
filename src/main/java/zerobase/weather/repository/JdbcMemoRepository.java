package zerobase.weather.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import zerobase.weather.domain.Memo;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemoRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMemoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Memo save(Memo memo) {
        jdbcTemplate.update("insert into memo values(?, ?)", memo.getId(), memo.getText());
        return memo;
    }

    public List<Memo> findAll() {
        return jdbcTemplate.query("select * from memo", memoRowMapper());
    }

    public Optional<Memo> findById(int id) {
        return jdbcTemplate.query("select * from memo where id = ?", memoRowMapper(), id).stream().findFirst();
    }

    private RowMapper<Memo> memoRowMapper() {
        return (rs, rowNum) -> new Memo(rs.getInt("id"), rs.getString("text"));
    }
}
