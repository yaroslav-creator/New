package com.javarush.task.task38.task3811;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

  // Должна быть публичная и доступна во время выполнения программы.
@Retention(value = RetentionPolicy.RUNTIME)

  // Применяться может только к новым типам данных
  // (Class, interface (including annotation type), or enum declaration).
@Target(ElementType.TYPE)
public @interface Ticket {

      // Должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
    public enum Priority {LOW, MEDIUM, HIGH};

    // Приоритет будет задавать свойство priority - по умолчанию Priority.MEDIUM.
    Priority priority() default Priority.MEDIUM;

    // Свойство tags будет массивом строк и будет хранить теги связанные с тикетом.
    String[] tags() default {};

    // Свойство createdBy будет строкой - по умолчанию Amigo.
    String createdBy() default "Amigo";
}
