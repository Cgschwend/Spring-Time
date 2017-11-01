@Repository
class JdbcWhizBangRepository implements WhizBangRepository {

@Autowired
JdbcTemplate jdbc

List<WhizBang> findByPlayer(String player) {
  jdbc.query(
    "select id, player, num1, num2, game " +
    "from WhizBang where player=?",
    { rs, row ->
      new WhizBang(id: rs.getLong(1),
          player: rs.getString(2),
          num1: rs.getInt(3),
          num2: rs.getInt(4),
          game: rs.getString(5))
      } as RowMapper,
      player)
}

void save(WhizBang whizBang) {

  whizBang.validateNums(whizBang.num1, whizBang.num2);
  whizBang.game = whizBang.setGame(whizBang.num1, whizBang.num2)


  jdbc.update("insert into WhizBang " +
    "(player, num1, num2, game) " +
    "values (?, ?, ?, ?)",
        whizBang.player,
        whizBang.num1,
        whizBang.num2,
        whizBang.game)
    }



}
