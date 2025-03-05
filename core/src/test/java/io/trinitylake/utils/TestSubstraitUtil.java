/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.trinitylake.utils;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.google.protobuf.ByteString;
import io.substrait.proto.NamedStruct;
import io.substrait.proto.Plan;
import io.substrait.proto.PlanRel;
import io.substrait.proto.ReadRel;
import io.substrait.proto.Rel;
import io.trinitylake.util.SubstraitUtil;
import org.junit.jupiter.api.Test;

public class TestSubstraitUtil {

  public static ByteString selectAllSubstraitPlanByteString() {
    Plan.Builder planBuilder = Plan.newBuilder();

    Rel.Builder relationBuilder = Rel.newBuilder();
    relationBuilder.setRead(
        ReadRel.newBuilder()
            .setBaseSchema(NamedStruct.newBuilder().addNames("table").build())
            .build());

    planBuilder.addRelations(PlanRel.newBuilder().setRel(relationBuilder.build()));

    return ByteString.copyFrom(planBuilder.build().toByteArray());
  }

  @Test
  public void testValidSubstraitPlan() {
    ByteString validPlan = selectAllSubstraitPlanByteString();

    // Expect no exception
    assertThatCode(() -> SubstraitUtil.loadSubstraitReadReal(validPlan)).doesNotThrowAnyException();
  }

  @Test
  public void testInvalidSubstraitPlan() {
    ByteString invalidPlan = ByteString.copyFromUtf8("non substrait plan");

    // Expect IllegalArgumentException when passing invalid data
    assertThatThrownBy(() -> SubstraitUtil.loadSubstraitReadReal(invalidPlan))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Invalid Substrait read relation");
  }

  @Test
  public void testEmptySubstraitPlan() {
    ByteString emptyPlan = ByteString.EMPTY;

    // Expect no exception
    assertThatThrownBy(() -> SubstraitUtil.loadSubstraitReadReal(emptyPlan))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("substraitReadRelBytes cannot be null or empty");
  }

  @Test
  public void testNullSubstraitPlan() {
    ByteString nullPlan = null;

    // Expect no exception
    assertThatThrownBy(() -> SubstraitUtil.loadSubstraitReadReal(nullPlan))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("substraitReadRelBytes cannot be null or empty");
  }
}
