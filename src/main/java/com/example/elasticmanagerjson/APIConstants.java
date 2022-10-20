package com.example.elasticmanagerjson;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

public class APIConstants {

    public static final String ELASTIC_SEARCH_URL = "/elasticSearch";
    public static final String ELASTIC_CACHE_SEARCH_URL = "/elasticCacheSearch";
    public static final String ELASTIC_HAK_SAHIPLIGI_URL = "/hakSahipligi";
    public static final String ELASTIC_KURUM_ADRES_URL = "/kurumAdres";
    public static final String ELASTIC_LOG = "/log";

    //V2
    public static final String API_URL_V2 = "/api/v2";
    public static final String API_V2_CUSTOMQUERY = "/customquery";
    public static final String API_V2_ADDCUSTOMQUERY = "/addcustomquery";
    public static final String API_V2_GETALLCUSTOMQUERYS = "/getallcustomquerys";
    public static final String API_V2_EXECUTECUSTOMQUERY = "/query";
    public static final String API_V2_UPDATEQUERY = "/updatequery";
    public static final String API_V2_DELETEQUERY = "/deletequery";

    public static final String API_URL = "/api";
    public static final String EXPORTED_API_URL = "/api/exported";
    public static final String IN_MEM_AUTH_URL = "/imapi";
    public static final String ACTUATOR_URL = "/actuator";
    public static final String SWAGGER_URL = "/swagger-ui";
    public static final String OPENAPI_URL = "openapi";
    public static final String API_REPORT_ADDRESS = "/reports";
    public static final String EMAIL_URL = "/email";

    public static final String MUDAHALE_URL = "/mudahale";
    public static final String MUDAHALE_DURUM_URL = "/mudahale/mudahaleDurum";
    public static final String MUDAHALE_BILGILERI_EKIP_URL = "/mudahale/mudahaleBilgileriEkip";
    public static final String MUDAHALE_BILGILERI_EKIP_KAYNAK_URL = "/mudahale/mudahaleBilgileriEkipKaynak";
    public static final String MUDAHALE_BILGILERI_EKIP_AFETZEDE_URL = "/mudahale/mudahaleBilgileriEkipAfetzede";

    public static final String AFETZEDE_URL = "/afetzede";
    public static final String AFETZEDE_TARIHCE_URL = "/afetzedeTarihce";
    public static final String AFETZEDE_DURUM_URL = "/afetzede/afetzedeDurum";
    public static final String AFETZEDE_KIMLIKLENDIRME_URL = "/afetzede/afetzedeKimliklendirme";
    public static final String AFETZEDE_AFED_GRUBU_KOORDINASYON_URL = "/afetzede/afetzedeAfedGrubuKoordinasyon";

    public static final String IHBAR_ISTEK_URL = "/ihbarIstek";
    public static final String IHBAR_ISTEK_TURU_URL = "/ihbarIstek/ihbarIstekTuru";

    public static final String IHBAR_ISTEK_GELIS_SEKLI_URL = "/ihbarIstek/ihbarIstekGelisSekli";
    public static final String IHBAR_ISTEK_DURUM_URL = "/ihbarIstek/ihbarIstekDurum";

    public static final String CALISMAGRUBU_URL = "/calismaGrubu";
    public static final String KBRN_URL = "/kbrn";
    public static final String BARINMA_URL = "/barinma";
    public static final String GUVENLIK_TRAFIK_URL = "/guvenlikTrafik";
    public static final String BESLENME_URL = "/beslenme";
    public static final String PSIKOSOSYAL_URL = "/psikososyal";
    public static final String GIDA_TARIM_HAYVANCILIK_URL = "/gidaTarimHayvancilik";
    public static final String TAHLIYE_YERLESTIRME_URL = "/tahliyeYerlestirme";
    public static final String TAHLIYE_YERLESTIRME_PLANLAMA_URL = "/tahliyeYerlestirmePlanlama";

    public static final String KULLANICI_ROL_GRUBU_URL = "/kullanici/rolGrubu";
    public static final String KULLANICI_ROL_URL = "/kullanici/rol";
    public static final String KULLANICI_YETKI_URL = "/kullanici/yetki";
    public static final String KULLANICI_MOBIL_KONUM_URL = "/kullanici/mobilKonum";

    /**
     * En az 1 büyük harf, 1 küçük harf ve 1 rakamdan oluşur. Toplamda en az 8 karakter olmalıdır.
     */
    public static final String USER_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$";

    public static final String UYDU_TELEFON_URL = "/uyduTelefon";

    public static final String ORGANIZASYON_URL = "/organizasyon";
    public static final String BOOKMARK_URL = "/bookmark";

    public static final String SATIN_ALMA_URL = "/satinAlma";
    public static final String AYDES_RAPOR_URL = "/aydesRapor";

    public static final String LAYER_URL = "/layer";

    public static final String ARAMA_URL = "/arama";


    public static final String DUYURU_URL = "/duyuru";

    public static final String CONFIGURATION_URL = "/configuration";
    public static final String KISI_URL = "/yonetim/kisi";
    public static final String YONETIM_URL = "/yonetim";

    public static final String KURUM_URL = "/kurum";

    public static final String LDAP_URL = "/ldap";

    public static final String LOOKUP_URL = "/lookup";
    public static final String ADRES = "/adres";
    public static final String MAKSADRES = "/maksadres";
    public static final String MAKSOTURAN = "/maksoturan";
    public static final String OLAY_URL = "/olay";
    public static final String OLAY_ILISKILERI_URL = "/olay/olayIliskileri";
    public static final String OLAY_TURU_URL = "/olay/olayTuru";
    public static final String OLAY_DURUMU_URL = "/olay/olayDurumu";

    public static final String SENARYO_OLAY_URL = "/senaryoOlay";

    public static final String FILE_UPLOAD_URL = "/fileUpload";

    public static final String ONERI_SORUN_URL = "/oneri";

    public static final String TESIS_URL = "/tesis";
    public static final String LOJISTIK_DEPO_URL = "/lojistikDepo";
    public static final String OLAY_BILDIRIM_URL = "/olayBildirim";
    public static final String ENGELLI_RAPOR_URL = "/engelliRapor";
    public static final String TOPLANMA_ALANI_URL = "/tesis/toplanmaAlani";

    public static final String AYNI_BAGIS_V2 = "/ayniBagis";
    public static final String DAGITIM = "/dagitim";

    public static final String TATBIKAT_AKTARIM_URL = "/tatbikatAktarim";

    public static final String KAYNAK = "/kaynak";
    public static final String KAYNAK_OZNITELIK = "/kaynakOznitelik";
    public static final String KAYNAK_KATEGORI = "/kaynakKategori";
    public static final String KAYNAK_CALISMAGRUBU = "/kaynakCalismaGrubu";
    public static final String KAYNAK_ZAYI = "/zayi";
    public static final String KAYNAK_TRANSFER = "/transfer";
    public static final String KAYNAK_TAMIR = "/kaynakTamir";

    public static final String KAYNAK_ENVANTER = "/kaynakEnvanter";
    public static final String KAYNAK_ENVANTER_OZNITELIK = "/kaynakEnvanterOznitelik";

    public static final String EKONOMIK_ETKI_URL = "/ekonomikEtki";

    public static final String TAHMIN_RAPORU_URL = "/tahminRaporu";

    public static final String GOREVLENDIRME_KISI_URL = "/gorevlendirmeKisi";
    public static final String GOREVLENDIRME_MUDAHALE_URL = "/gorevlendirmeMudahale";
    public static final String GOREVLENDIRME_URL = "/gorevlendirme";
    public static final String ARAC_GOREVLENDIRME_URL = "/aracGorevlendirme";

    public static final String ELASTIC = "/elastic";

    public static final String UYGULAMA_VERSIYON = "/uygulamaVersiyon";

    public static final String MUHTAR = "/muhtar";

    public static final String YILDIZ = "/yildiz";

    public static final String GENERIC = "/generic";

    public static final String ASOS = "/asos";

    public static final String MEDIA = "/media";



    private APIConstants() {

    }

    public static MultivaluedMap<String, Object> createHeaders(String bearerToken){
        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.add("Content-Type","application/json");
        headers.add("Authorization",bearerToken);
        return headers;
    }

}
