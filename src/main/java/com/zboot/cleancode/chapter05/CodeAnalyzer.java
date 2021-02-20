package com.zboot.cleancode.chapter05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CodeAnalyzer implements JavaFileAnalysis {
    private int lineCount;
    private int maxLineWidth;
    private int widestLineNumber;
    private LinewidthHistogram linewidthHistogram;
    private int totalChars;

    public CodeAnalyzer() {
        linewidthHistogram = new LinewidthHistogram();
    }

    public static List<File> findJavaFiles(File parentDirectory) {
        List<File> files = new ArrayList<File>();
        findJavaFiles(parentDirectory, files);
        return files;
    }

    private static void findJavaFiles(File parentDirectory, List<File> files) {
        for (File file : parentDirectory.listFiles()) {
            if (file.getName().endsWith(".java")) {
                files.add(file);
            } else if (file.isDirectory()) {
                findJavaFiles(file, files);
            }
        }
    }

    public void analyzeFile(File javaFile) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(javaFile));
        String line;
        while ((line = br.readLine()) != null) {
            measureLine(line);
        }
    }

    private void measureLine(String line) {
        lineCount++;
        int lineSize = line.length();
        linewidthHistogram.addLine(lineSize, lineCount);
        totalChars += lineSize;
        recordWidestLine(lineSize);
    }

    private void recordWidestLine(int lineSize) {
        if (lineSize > maxLineWidth) {
            maxLineWidth = lineSize;
            widestLineNumber = lineCount;
        }
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getMaxLinewidth() {
        return maxLineWidth;
    }

    public int getWidestLineNumber() {
        return widestLineNumber;
    }

    public LinewidthHistogram getLineWidthHistogram() {
        return linewidthHistogram;
    }

    public double getMeanLinewWidth() {
        return (double) totalChars / lineCount;
    }

    public int getMedianLinewidth() {
        Integer[] sortedwidths = getSortedwidths();
        int cumulativeLineCount = 0;
        for (int width : sortedwidths) {
            cumulativeLineCount += lineCountForwidth(width);
            if (cumulativeLineCount > lineCount / 2) {
                return width;
            }
        }
        throw new Error("Cannot get here");
    }

    private int lineCountForwidth(int width) {
        return linewidthHistogram.getLinesforWidth(width).size();
    }

    private Integer[] getSortedwidths() {
        Set<Integer> widths = linewidthHistogram.getWidths();
        Integer[] sortedwidths = (widths.toArray(new Integer[0]));
        Arrays.sort(sortedwidths);
        return sortedwidths;
    }
}
