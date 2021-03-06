/*
 * Copyright (C) 2020-present, Chenai Nakam(chenai.nakam@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Chenai Nakam(chenai.nakam@gmail.com)
 * @version 1.0, 13/01/2020
 */
public class RoadGuihua {
    int sumLuJing(int[][] array) {
        AtomicInteger integer = new AtomicInteger(0);
        f(array[0].length - 1, array.length - 1, integer, null);
        return integer.get();
    }

    void f(int x, int y, AtomicInteger i, Boolean direction) {
        if (direction == null) {
            if (x > 0) {
                i.incrementAndGet();
                f(x - 1, y, i, Boolean.FALSE);
            }
            if (y > 0) {
                i.incrementAndGet();
                f(x, y - 1, i, Boolean.TRUE);
            }
        } else if (x > 0 && y > 0) {
            if (direction) {
                i.incrementAndGet();
                f(x - 1, y, i, Boolean.FALSE);
            } else {
                i.incrementAndGet();
                f(x, y - 1, i, Boolean.TRUE);
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[4][3];
        int sum = new RoadGuihua().sumLuJing(a);
        System.out.println(sum);
    }
}
