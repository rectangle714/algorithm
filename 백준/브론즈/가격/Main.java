package 백준.브론즈.가격;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        StringTokenizer st;
        Map<String, Object> couponMap = Map.of(
                "R", 0.45,
                "G", 0.30,
                "B", 0.20,
                "Y", 0.15,
                "O", 0.10,
                "W", 0.05
        );

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        // 구매자 수
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String dollar = st.nextToken();
            double defaultSale = (double)couponMap.get(st.nextToken());
            boolean isGetCoupon = "C".equals(String.valueOf(st.nextToken()));
            boolean isCash = "C".equals(String.valueOf(st.nextToken()));

            BigDecimal bd = new BigDecimal(dollar);
            bd = bd.subtract(bd.multiply(new BigDecimal(defaultSale)).setScale(2, RoundingMode.HALF_UP));  // 1. 할인율 계산
            if(isGetCoupon) {
                bd = bd.subtract(bd.multiply(new BigDecimal("0.05"))).setScale(2, RoundingMode.HALF_UP);
            }

            if(isCash) {
                if(bd.movePointRight(2).remainder(BigDecimal.TEN).intValue() == 5) {
                    bd = bd.setScale(1, RoundingMode.DOWN);
                } else{
                    bd = bd.setScale(1, RoundingMode.HALF_UP);
                }
            }
            DecimalFormat df = new DecimalFormat("0.00");

            System.out.println("$"+df.format(bd.doubleValue()));
        }
    }
}
