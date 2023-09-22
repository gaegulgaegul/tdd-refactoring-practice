package me.gaegul.refactoring.ch11.no13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("예외를 사전확인으로 바꾸기")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ReplaceExceptionWithPrecheckTest {
    private ResourcePool sut;

    @BeforeEach
    void setUp() {
        this.sut = new ResourcePool();
    }

    @Nested
    class ResourcePool_클래스의_get_메서드는 {

        @Nested
        class 가용_풀_자원이_있으면 {

            @Test
            void 해당_자원을_반환한다() {
                Resource resource = Resource.create();

                sut.addAvailableResource(resource);

                Resource availableResource = sut.get();
                assertThat(availableResource).isEqualTo(resource);
            }
        }

        @Nested
        class 가용_풀_자원이_없으면 {

            @Test
            void 새로운_자원을_반환한다() {
                boolean empty = sut.getAvailable().isEmpty();
                Resource availableResource = sut.get();
                assertThat(empty).isTrue();
                assertThat(availableResource).isNotNull();
            }
        }
    }
}
