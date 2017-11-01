@Controller
@RequestMapping("/")
class WhizBangController {

  String player = "Craig"

  @Autowired
  WhizBangRepository whizBangRepository

  @RequestMapping(method=RequestMethod.GET)
  def playersWhizBangs(Model model) {
    List<WhizBang> whizBangList =
        whizBangRepository.findByPlayer(player)

    if (whizBangList != null) {
      model.addAttribute("whizBangs", whizBangList)
    }

    "whizBangList"
  }

  @RequestMapping(method=RequestMethod.POST)
  def addToWhizBangList(WhizBang whizBang) {
    whizBang.setPlayer(player)
    whizBangRepository.save(whizBang)
    "redirect:/"
  }

}
