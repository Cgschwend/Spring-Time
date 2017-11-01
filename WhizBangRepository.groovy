interface WhizBangRepository {
  List<WhizBang> findByPlayer(String player)

  void save(WhizBang whizBang)

}
