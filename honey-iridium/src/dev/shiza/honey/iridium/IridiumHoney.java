package dev.shiza.honey.iridium;

import dev.shiza.honey.Honey;
import dev.shiza.honey.message.MessageCompiler;
import dev.shiza.honey.placeholder.evaluator.PlaceholderContext;
import dev.shiza.honey.placeholder.evaluator.PlaceholderEvaluator;
import dev.shiza.honey.placeholder.resolver.PlaceholderResolver;
import dev.shiza.honey.placeholder.sanitizer.PlaceholderSanitizer;
import dev.shiza.honey.reflection.ReflectivePlaceholderEvaluatorFactory;

public interface IridiumHoney extends Honey<String> {

  static IridiumHoney createReflective() {
    return createReflective(PlaceholderContext.create());
  }

  static IridiumHoney createReflective(final PlaceholderContext globalContext) {
    return create(
        IridiumMessageCompilerFactory.create(),
        globalContext,
        PlaceholderResolver.create(),
        PlaceholderSanitizer.create(),
        ReflectivePlaceholderEvaluatorFactory.create());
  }

  private static IridiumHoney create(
      final MessageCompiler<String> messageCompiler,
      final PlaceholderContext globalContext,
      final PlaceholderResolver placeholderResolver,
      final PlaceholderSanitizer placeholderSanitizer,
      final PlaceholderEvaluator placeholderEvaluator) {
    return new IridiumHoneyImpl(
        messageCompiler,
        globalContext,
        placeholderResolver,
        placeholderSanitizer,
        placeholderEvaluator);
  }
}
