import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AUTO extends JFrame {
    JButton b1 = new JButton("Start");
    JCheckBox cb1 = new JCheckBox("스나이퍼 필수편성(체크시 랜덤스나1명 무조건편성)", false);
    JLabel l = new JLabel("아래 'Start' 버튼을 눌러 시작하세요");

    boolean Act_Sni = false;

    public AUTO(String s) {
        super(s);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src/imgData/555.png");
        setIconImage(img);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(50, 50, 660, 400);
        setVisible(true);
        setLayout(new BorderLayout(0, 0));
        Font font = new Font("나눔고딕", Font.BOLD, 16);
        l.setFont(font);
        setBackground(Color.WHITE);
//        cb1.addItemListener(new item1());
        b1.addActionListener(new actions1());
        add(b1, BorderLayout.SOUTH);
        add(cb1, BorderLayout.NORTH);
        add(l, BorderLayout.CENTER);
    }

//    class item1 implements ItemListener {
//        @Override
//        public void itemStateChanged(ItemEvent e){
//            if(e.getStateChange() == ItemEvent.SELECTED){
//                Act_Sni = true;
//            }else{
//                Act_Sni = false;
//            }
//        }
//    }

    class actions1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (b1.getText().equals("Start")) {
                String Message = "<html><body>";
                String op[] = new String[12];
                String st = "";
                int c = 0;//카운트
                int hard = 0;//하드모드여부
                int danger = 0;//고난이도여부

                String a[] = {"써멀", "란셋", "캐슬", "저스티스나이트",
                        "야토", "레인저", "두린", "느와르코르네", "12층",
                        "히비스커스", "플룸", "포푸카", "팽", "크루스", "캐터펄트", "카디건", "오키드", "안셀", "아드나키엘", "스팟", "스튜어드", "비글", "바닐라", "미드나이트", "멜란사", "라바",
                        "헤이즈", "프로스트리프", "퓨어스트림", "푸딩", "포덴코", "퍼퓨머", "파인콘", "클릭", "쿠오라", "쿠리어", "컨빅션", "커터", "체스트넛", "제이", "제시카", "재키", "인디고",
                        "우타게", "엠브리엘", "에스텔", "에단", "어스스피릿", "애시드드롭", "아렌", "시라유키", "스캐빈저", "수수로", "쇼", "소흑", "빈스토크", "비헌터", "비그나", "버블", "버메일",
                        "미르", "무스", "메테오", "메이", "머틀", "마토이마루", "마터호른", "로프", "로베르타", "딥컬러", "듀나", "도베르만", "기타노", "그레이", "그라벨", "굼", "가비알",
                        "이격히비스", "헤비레인", "허니베리", "하이디", "플린트", "플레임브링어", "플래티넘", "프틸롭시스", "프로스트", "프로방스", "프로바이조", "프란카", "프라마닉스", "폴리닉",
                        "파이어워치", "투예", "토미미", "토디폰스", "텍사스", "테킬라", "타찬카", "키아베", "키라라", "클리프하트", "크루아상", "이격크루스", "퀘르쿠스", "코로세럼", "칸타빌레",
                        "카프카", "카제마루", "츠키노기", "체르니", "지마", "인포서", "인드라", "이스티나", "이그제큐터", "윈드플릿", "위슬래시", "위스퍼레인", "우요우", "와파린", "와일드메인",
                        "와이후", "오로라", "엘리시움", "애프이터", "에이프릴", "에이어스카르페", "에라토", "애쉬락", "압생트", "안드레아나", "아카후유", "아이리스", "아오스타", "아스트젠",
                        "아스테시아", "아스베스토스", "아미야", "가드아미야", "씬", "실론", "시데로카", "스펙터", "스카이파이어", "스와이어", "스노우상트", "쉐라", "소라", "세사", "샬렘", "샤마르",
                        "새비지", "사일런스", "비즈왁스", "블리츠", "블루포이즌", "블랙나이트", "브리즈", "브로카", "베나", "벌컨", "바이슨", "바이비크", "민트", "미니멀리스트", "메테오라이트",
                        "메이어", "멀베리", "맨티코어", "리스캄", "리드", "로빈", "레이즈", "레온하르트", "레드", "락락", "라플란드", "이격라바", "라플루마", "다그다", "니어", "구색록",
                        "나이트메어", "글라우쿠스", "그레이스롯", "이격그레이", "그라니", "토터", "파프리카",
                        "W", "혼", "호시구마", "헬라그", "피아메타", "플레임테일", "팬텀", "패신저", "팔라스", "파투스", "파죰카", "켈시", "케오베", "카넬리안", "수첸", "첸", "이프리트",
                        "유넥티스", "위디", "엑시아", "에이야퍄들라", "에벤홀츠", "애쉬", "안젤리나", "아이린", "아르케토", "아", "쏜즈", "실버애쉬", "시즈", "시", "언펙터", "스테인리스",
                        "보카디", "스카디", "스즈란", "슈바르츠", "수르트", "샤이닝", "사일라흐", "사리아", "사가", "블레이즈", "블레미샤인", "백파이프", "미즈키", "무에나", "모스티마",
                        "머드락", "마젤란", "마운틴", "링", "리", "루멘", "로즈몬티스", "로사", "도로시", "니엔", "근니어", "노시스", "나이팅게일", "글래디아", "골든글로우", "수비알"};

                String star6[] = {
                        "W", "혼", "호시구마", "헬라그", "피아메타", "플레임테일", "팬텀", "패신저", "팔라스", "파투스", "파죰카", "켈시", "케오베", "카넬리안", "수첸", "첸", "이프리트",
                        "유넥티스", "위디", "엑시아", "에이야퍄들라", "에벤홀츠", "애쉬", "안젤리나", "아이린", "아르케토", "아", "쏜즈", "실버애쉬", "시즈", "시", "언펙터", "스테인리스",
                        "보카디", "스카디", "스즈란", "슈바르츠", "수르트", "샤이닝", "사일라흐", "사리아", "사가", "블레이즈", "블레미샤인", "백파이프", "미즈키", "무에나", "모스티마",
                        "머드락", "마젤란", "마운틴", "링", "리", "루멘", "로즈몬티스", "로사", "도로시", "니엔", "근니어", "노시스", "나이팅게일", "글래디아", "골든글로우", "수비알"
                };

                String b[] = {"4-1", "4-2", "4-3", "4-4", "4-5", "4-6", "4-7", "4-8", "4-9", "4-10", "S4-1", "S4-2", "S4-3", "S4-4", "S4-5", "S4-6", "S4-7", "S4-8",
                        "S4-9", "S4-10", "5-1", "5-2", "5-3", "5-4", "5-5", "5-6", "5-7", "5-8", "5-9", "5-10", "S5-1", "S5-2", "S5-3", "S5-4", "S5-5", "S5-6", "S5-7", "S5-8",
                        "S5-9", "H5-1", "H5-2", "H5-3", "H5-4", "6-1", "6-2", "6-3", "6-4", "6-5", "6-8", "6-9", "6-10", "6-11", "6-12", "6-14", "6-15", "6-16",
                        "S6-1", "S6-2", "S6-3", "S6-4", "H6-1", "H6-2", "H6-3", "H6-4", "7-2", "7-3", "7-4", "7-5", "7-6", "7-8", "7-9", "7-10", "7-11", "7-12", "7-13", "7-14",
                        "7-15", "7-16", "7-17", "7-18", "S7-1", "S7-2", "H7-1", "H7-2", "H7-3", "H7-4", "R8-1", "R8-2", "R8-3", "R8-4", "R8-5", "R8-6", "R8-7", "R8-8", "R8-9",
                        "R8-10", "R8-11", "M8-6", "M8-7", "M8-8", "JT8-2", "JT8-3", "H8-1", "H8-2", "H8-3", "H8-4", "9-2", "9-3", "9-4", "9-5", "9-6", "9-7", "9-9", "9-10",
                        "9-11", "9-12", "9-13", "9-14", "9-15", "9-16", "9-17", "9-18", "9-19", "S9-1", "S9-2", "H9-1", "H9-2", "H9-3", "H9-4", "H9-5", "H9-6",
                        "10-2", "10-3", "10-4", "10-5", "10-6", "10-7", "10-8", "10-9", "10-10", "10-11", "10-12", "10-14", "10-15", "10-16", "10-17", "H10-1", "H10-2", "H10-3",
                        "11-1", "11-2", "11-3", "11-5", "11-6", "11-7", "11-8", "11-9", "11-11", "11-12", "11-13", "11-14", "11-16", "11-18", "11-20", "H11-1", "H11-2", "H11-3", "H11-4",
                        "GT-1", "GT-2", "GT-3", "GT-4", "GT-5", "GT-6", "GT-EX-1", "GT-EX-2", "GT-EX-3", "GT-HX-1", "GT-HX-2", "GT-HX-3", "OF-1", "OF-2", "OF-3", "OF-4",
                        "OF-5", "OF-6", "OF-EX1", "OF-EX2", "OF-EX3", "OF-EX4", "OF-EX5", "OF-EX6", "OF-F1", "OF-F2", "OF-F3", "OF-F4", "CB-1", "CB-2", "CB-3", "CB-4", "CB-5",
                        "CB-6", "CB-7", "CB-8", "CB-9", "CB-10", "CB-EX1", "CB-EX2", "CB-EX3", "CB-EX4", "CB-EX5", "CB-EX6", "CB-EX7", "CB-EX8", "TW-1", "TW-2", "TW-3", "TW-4",
                        "TW-5", "TW-6", "TW-7", "TW-8", "TW-S-1", "TW-S-2", "TW-EX-1", "TW-EX-2", "TW-EX-3", "TW-EX-4", "TW-EX-5", "TW-EX-6", "TW-EX-7", "TW-EX-8", "RI-1", "RI-2",
                        "RI-3", "RI-4", "RI-5", "RI-6", "RI-7", "RI-8", "RI-9", "RI-EX-1", "RI-EX-2", "RI-EX-3", "RI-EX-4", "RI-EX-5", "RI-EX-6", "RI-EX-7", "RI-EX-8", "MN-1",
                        "MN-2", "MN-3", "MN-4", "MN-5", "MN-6", "MN-7", "MN-8", "MN-EX-1", "MN-EX-2", "MN-EX-3", "MN-EX-4", "MN-EX-5", "MN-EX-6", "MN-EX-7", "MN-EX-8", "MB-1",
                        "MB-2", "MB-3", "MB-4", "MB-5", "MB-6", "MB-7", "MB-8", "MB-EX-1", "MB-EX-2", "MB-EX-3", "MB-EX-4", "MB-EX-5", "MB-EX-6", "MB-EX-7", "MB-EX-8", "WR-1",
                        "WR-2", "WR-3", "WR-4", "WR-5", "WR-6", "WR-7", "WR-8", "WR-9", "WR-10", "WR-EX-1", "WR-EX-2", "WR-EX-3", "WR-EX-4", "WR-EX-5", "WR-EX-6", "WR-EX-7",
                        "WR-EX-8", "DH-1", "DH-2", "DH-3", "DH-4", "DH-5", "DH-6", "DH-7", "DH-8", "DH-9", "DH-EX-1", "DH-EX-2", "DH-EX-3", "DH-EX-4", "DH-EX-5", "DH-EX-6",
                        "DH-EX-7", "DH-EX-8", "DH-S-1", "DH-S-2", "DH-S-3", "DH-S-4", "NL-1", "NL-2", "NL-3", "NL-4", "NL-5", "NL-6", "NL-7", "NL-8", "NL-9", "NL-10", "NL-EX-1",
                        "NL-EX-2", "NL-EX-3", "NL-EX-4", "NL-EX-5", "NL-EX-6", "NL-EX-7", "NL-EX-8", "NL-S-1", "NL-S-2", "NL-S-3", "NL-S-4", "NL-S-5", "DM-1", "DM-2", "DM-3",
                        "DM-4", "DM-5", "DM-6", "DM-7", "DM-8", "DM-EX-1", "DM-EX-2", "DM-EX-3", "DM-EX-4", "DM-EX-5", "DM-EX-6", "WD-1", "WD-2", "WD-3", "WD-4", "WD-5", "WD-6",
                        "WD-7", "WD-8", "WD-EX-1", "WD-EX-2", "WD-EX-3", "WD-EX-4", "WD-EX-5", "WD-EX-6", "WD-EX-7", "WD-EX-8", "SV-1", "SV-2", "SV-3", "SV-4", "SV-5", "SV-6",
                        "SV-7", "SV-8", "SV-9", "SV-EX-1", "SV-EX-2", "SV-EX-3", "SV-EX-4", "SV-EX-5", "SV-EX-6", "SV-EX-7", "SV-EX-8", "SN-1", "SN-2", "SN-3", "SN-4", "SN-5",
                        "SN-6", "SN-7", "SN-8", "SN-9", "SN-10", "SN-EX-1", "SN-EX-2", "SN-EX-3", "SN-EX-4", "SN-EX-5", "SN-EX-6", "SN-EX-7", "SN-EX-8", "SN-S-1-A",
                        "SN-S-1-B", "SN-S-2-A", "SN-S-2-B", "SN-S-3-A", "SN-S-3-B", "SN-S-4-A", "SN-S-4-B", "SN-S-5"};

                String Sni[] = {
                        "저스티스나이트", "레인저", "크루스", "캐터펄트", "아드나키엘", "파인콘", "제시카", "엠브리엘", "애시드드롭", "시라유키", "버메일", "메테오",
                        "메이", "플래티넘", "프로방스", "파이어워치", "토디폰스", "이격크루스", "이그제큐터", "에이프릴", "에라토", "안드레아나", "아오스타", "세사",
                        "블루포이즌", "메테오라이트", "그레이스롯", "이격그레이", "토터", "W", "피아메타", "파투스", "파죰카", "수첸", "엑시아", "애쉬",
                        "아르케토", "로즈몬티스"
                };

//                System.out.println(Sni.length);

                //하드모드 체크여부
                hard = (int) (Math.random() * 2) + 1;

                //랜덤 스테이지(EX, S, 스토리8지 이상 6성 지참여부 체크)
                c = (int) (Math.random() * 417);
                st = b[c - 1];
                if (st.contains("EX")) {
                    danger = 1;
                } else if (c >= 87 && c <= 168) {
                    danger = 1;
                } else if (st.charAt(0) == 'H') {
                    danger = 1;
                } else if (st.contains("-S-")) {
                    danger = 1;
                } else if (hard == 1 && c >= 64 && c <= 86) {
                    danger = 1;
                }

                //오퍼 편성(EX, S, 스토리8지 이상일시 11명편성)
                //(그이하일시 12명 그대로편성)
                if (danger == 0 && Act_Sni == false) {
                    for (int i = 0; i < 12; i++) {
                        c = (int) (Math.random() * 253);
                        op[i] = a[c];

                        for (int j = 0; j < i; j++) {
                            if (op[i] == op[j]) {
                                i--;
                                break;
                            }
                        }
                    }
                } else if(danger == 0 && Act_Sni == true) {
                    c = (int) (Math.random() * 38);
                    op[0] = Sni[c];

                    for (int i = 1; i < 12; i++) {
                        c = (int) (Math.random() * 253);
                        op[i] = a[c];

                        for (int j = 1; j < i; j++) {
                            if (op[i] == op[j]) {
                                i--;
                                break;
                            } else if (op[0].equals(op[j])) {
                                i--;
                                break;
                            }
                        }
                    }
                }else if (danger == 1 && Act_Sni == false) { //고난이도 편성
                    Message += "고난이도 감지, 6성 1개 필수편성<br>";
                    c = (int) (Math.random() * 60);
                    op[0] = star6[c];

                    for (int i = 1; i < 12; i++) {
                        c = (int) (Math.random() * 253);
                        op[i] = a[c];

                        for (int j = 1; j < i; j++) {
                            if (op[i] == op[j]) {
                                i--;
                                break;
                            } else if (op[0].equals(op[j])) {
                                i--;
                                break;
                            }
                        }
                    }
                }else if(danger == 1 && Act_Sni == true){
                    Message += "고난이도 감지, 6성 1개 필수편성<br>";
                    c = (int) (Math.random() * 60);
                    op[0] = star6[c];

                    c = (int) (Math.random() * 38);
                    op[1] = Sni[c];

                    for (int i = 2; i < 12; i++) {
                        c = (int) (Math.random() * 253);
                        op[i] = a[c];

                        for (int j = 1; j < i; j++) {
                            if (op[i] == op[j]) {
                                i--;
                                break;
                            } else if (op[0].equals(op[1])) {
                                i--;
                                break;
                            }else if (op[0].equals(op[j])) {
                                i--;
                                break;
                            } else if (op[1].equals(op[j])) {
                                i--;
                                break;
                            }
                        }
                    }
                }

                Message += "<br>편성: <br>";

                for (int i = 0; i < 12; i++) {
                    if (i == 11) {
                        Message += op[i] + "<br><br>";
                        break;
                    } else if (i == 5) {
                        Message += op[i] + "<br>";
                    } else {
                        Message += op[i] + " / ";
                    }
                }

                Message += "스테이지: " + st + "<br>";

                if (hard == 1) {
                    Message += "하드모드: ON<br>";
                } else {
                    Message += "하드모드: OFF<br>";
                }
                Message += "(* 하드모드가 없거나, 이미 하드모드여야만 나타나는 맵인경우 적용여부 신경 X)" +
                        "</body></html>";
                l.setText(Message);
            }
        }
    }

    public static void main(String[] args) {
        new AUTO("Arknights Random Challenge");
    }
}

