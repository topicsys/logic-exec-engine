import java.util
import java.util.concurrent.locks.ReentrantReadWriteLock
import org.openjdk.jol.info.ClassLayout
import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll, FeatureSpec, GivenWhenThen}
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

/**
 * @author Chenai Nakam(chenai.nakam@gmail.com)
 * @version 1.0, 08/01/2020
 */
class ClassLayoutTest extends /*AsyncFeatureSpec*/ FeatureSpec with GivenWhenThen with BeforeAndAfter with BeforeAndAfterAll {
  override protected def beforeAll(): Unit = {
  }

  Feature("Class Layout Test") {
    Scenario("class layout:") {
      val o = new Object
      println {
        ClassLayout.parseInstance(o).toPrintable
      }
      val a = new A
      println {
        ClassLayout.parseInstance(a).toPrintable
      }
      println {
        a.synchronized {
          ClassLayout.parseInstance(a).toPrintable
        }
      }
      println {
        ClassLayout.parseInstance(a).toPrintable
      }
      val m = new util.HashMap[String, Object]
      println {
        ClassLayout.parseInstance(m).toPrintable
      }
      assert(true)
    }
  }
}