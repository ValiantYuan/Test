package com.yuanqi.quiz.oodesign;

/**
 * @author : yuanqi
 */
public abstract class Shape {
    public String draw() {
        StringBuilder stringBuilder = new StringBuilder();
        preProcessing(stringBuilder);
        stringBuilder.append(doActualDrawing());
        postProcessing(stringBuilder);
        return stringBuilder.toString();
    }

    private void preProcessing(StringBuilder stringBuilder) {
        stringBuilder.append("do pre processing\n");
    }

    private void postProcessing(StringBuilder stringBuilder) {
        stringBuilder.append("\ndo post processing");
    }

    protected abstract String doActualDrawing();
}
