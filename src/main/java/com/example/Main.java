package com.example;

// Інтерфейс Image
interface Image {
    byte[] getData();
    void apply();
}

// Базовий клас зображення
class BaseImage implements Image {
    private byte[] data;

    public BaseImage(byte[] data) {
        this.data = data;
    }

    @Override
    public byte[] getData() {
        return data;
    }

    @Override
    public void apply() {
        // Початкове зображення без фільтрів
        System.out.println("Original image data.");
    }
}

// Абстрактний клас фільтра
abstract class ImageFilter implements Image {
    protected Image image;

    public ImageFilter(Image image) {
        this.image = image;
    }

    @Override
    public byte[] getData() {
        return image.getData();
    }

    @Override
    public void apply() {
        image.apply();
    }
}

// Конкретний фільтр "Чорно-білий"
class BlackAndWhiteFilter extends ImageFilter {
    public BlackAndWhiteFilter(Image image) {
        super(image);
    }

    @Override
    public void apply() {
        super.apply();
        System.out.println("Applying Black and White Filter.");
    }
}

// Конкретний фільтр "Розмиття"
class BlurFilter extends ImageFilter {
    public BlurFilter(Image image) {
        super(image);
    }

    @Override
    public void apply() {
        super.apply();
        System.out.println("Applying Blur Filter.");
    }
}

// Конкретний фільтр "Зміна яскравості"
class BrightnessFilter extends ImageFilter {
    public BrightnessFilter(Image image) {
        super(image);
    }

    @Override
    public void apply() {
        super.apply();
        System.out.println("Applying Brightness Adjustment Filter.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Ініціалізація даних зображення
        byte[] imageData = new byte[]{/* Дані зображення */};

        // Створення базового зображення
        Image image = new BaseImage(imageData);

        // Додавання фільтрів
        image = new BlackAndWhiteFilter(image);
        image = new BlurFilter(image);
        image = new BrightnessFilter(image);

        // Застосування фільтрів
        System.out.println("Застосування фільтрів до зображення:");
        image.apply();

        // Видалення фільтру (наприклад, видалення фільтру "Розмиття")
        image = new BlackAndWhiteFilter(new BrightnessFilter(new BaseImage(imageData)));

        // Застосування фільтрів після видалення одного
        System.out.println("\nПісля видалення фільтру 'Розмиття':");
        image.apply();
    }
}
