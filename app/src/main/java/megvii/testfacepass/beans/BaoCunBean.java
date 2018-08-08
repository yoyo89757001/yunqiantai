package megvii.testfacepass.beans;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by Administrator on 2017/9/15.
 */
@Entity
public class BaoCunBean {
    @Id(assignable = true)
    private Long id;
    private String shipingIP;
    private String zhujiDiZhi;
    private int moban;
    private String tuisongDiZhi;
    private String gonggao;
    private boolean isShowMoshengren;
    private boolean isShowShiPingLiu;
    private boolean isHengOrShu;
    private int yusu;
    private int yudiao;
    private int boyingren;
    private String zhanghuId;
    private String wenzi;
    private int size;
    private String touxiangzhuji;
    private String houtaiDiZhi;
    private String huiyiId;
    private String wenzi1;
    private int size1;
    private String guanggaojiMing;
    private String shiPingWeiZhi;
    private String zhanhuiId;
    private String zhanhuiBianMa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShipingIP() {
        return shipingIP;
    }

    public void setShipingIP(String shipingIP) {
        this.shipingIP = shipingIP;
    }

    public String getZhujiDiZhi() {
        return zhujiDiZhi;
    }

    public void setZhujiDiZhi(String zhujiDiZhi) {
        this.zhujiDiZhi = zhujiDiZhi;
    }

    public int getMoban() {
        return moban;
    }

    public void setMoban(int moban) {
        this.moban = moban;
    }

    public String getTuisongDiZhi() {
        return tuisongDiZhi;
    }

    public void setTuisongDiZhi(String tuisongDiZhi) {
        this.tuisongDiZhi = tuisongDiZhi;
    }

    public String getGonggao() {
        return gonggao;
    }

    public void setGonggao(String gonggao) {
        this.gonggao = gonggao;
    }

    public boolean isShowMoshengren() {
        return isShowMoshengren;
    }

    public void setShowMoshengren(boolean showMoshengren) {
        isShowMoshengren = showMoshengren;
    }

    public boolean isShowShiPingLiu() {
        return isShowShiPingLiu;
    }

    public void setShowShiPingLiu(boolean showShiPingLiu) {
        isShowShiPingLiu = showShiPingLiu;
    }

    public boolean isHengOrShu() {
        return isHengOrShu;
    }

    public void setHengOrShu(boolean hengOrShu) {
        isHengOrShu = hengOrShu;
    }

    public int getYusu() {
        return yusu;
    }

    public void setYusu(int yusu) {
        this.yusu = yusu;
    }

    public int getYudiao() {
        return yudiao;
    }

    public void setYudiao(int yudiao) {
        this.yudiao = yudiao;
    }

    public int getBoyingren() {
        return boyingren;
    }

    public void setBoyingren(int boyingren) {
        this.boyingren = boyingren;
    }

    public String getZhanghuId() {
        return zhanghuId;
    }

    public void setZhanghuId(String zhanghuId) {
        this.zhanghuId = zhanghuId;
    }

    public String getWenzi() {
        return wenzi;
    }

    public void setWenzi(String wenzi) {
        this.wenzi = wenzi;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getTouxiangzhuji() {
        return touxiangzhuji;
    }

    public void setTouxiangzhuji(String touxiangzhuji) {
        this.touxiangzhuji = touxiangzhuji;
    }

    public String getHoutaiDiZhi() {
        return houtaiDiZhi;
    }

    public void setHoutaiDiZhi(String houtaiDiZhi) {
        this.houtaiDiZhi = houtaiDiZhi;
    }

    public String getHuiyiId() {
        return huiyiId;
    }

    public void setHuiyiId(String huiyiId) {
        this.huiyiId = huiyiId;
    }

    public String getWenzi1() {
        return wenzi1;
    }

    public void setWenzi1(String wenzi1) {
        this.wenzi1 = wenzi1;
    }

    public int getSize1() {
        return size1;
    }

    public void setSize1(int size1) {
        this.size1 = size1;
    }

    public String getGuanggaojiMing() {
        return guanggaojiMing;
    }

    public void setGuanggaojiMing(String guanggaojiMing) {
        this.guanggaojiMing = guanggaojiMing;
    }

    public String getShiPingWeiZhi() {
        return shiPingWeiZhi;
    }

    public void setShiPingWeiZhi(String shiPingWeiZhi) {
        this.shiPingWeiZhi = shiPingWeiZhi;
    }

    public String getZhanhuiId() {
        return zhanhuiId;
    }

    public void setZhanhuiId(String zhanhuiId) {
        this.zhanhuiId = zhanhuiId;
    }

    public String getZhanhuiBianMa() {
        return zhanhuiBianMa;
    }

    public void setZhanhuiBianMa(String zhanhuiBianMa) {
        this.zhanhuiBianMa = zhanhuiBianMa;
    }
}