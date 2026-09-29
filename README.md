# Water Quality Monitor

سامانه سبک ثبت و تحلیل داده‌های کیفیت آب — پروژه تیم Nexora.

## وضعیت فعلی: 80%

### قابلیت‌های پیاده‌سازی‌شده
- ثبت pH، دما، DO و EC همراه محل، زمان و توضیحات
- داشبورد و سوابق اندازه‌گیری
- جستجو و فیلتر بازه زمانی
- حذف رکورد
- آمار خلاصه و نمودارهای روند با Chart.js
- تشخیص مقادیر خارج از محدوده‌های مرجع نمونه
- صفحه هشدارها
- خروجی CSV سازگار با Excel

> محدوده‌های هشدار نسخه نمونه اولیه، مقادیر مرجع نمایشی هستند و برای کاربرد واقعی باید بر اساس استاندارد و نوع مصرف آب تنظیم شوند.

### فناوری‌ها
Java 21 · Spring Boot 3 · Spring MVC · Thymeleaf · Spring Data JPA · MySQL/H2 · Bootstrap RTL · Chart.js · Maven

### اجرا
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```
سپس `http://localhost:8080`

## Roadmap
- [x] 20% — Core setup + registration + dashboard
- [x] 40% — History, search and filters
- [x] 60% — Charts and analysis
- [x] 80% — Reference thresholds, alerts and spreadsheet-friendly export
- [ ] 100% — Testing, documentation and delivery

گزارش‌ها: [20%](PROGRESS_20.md) · [40%](PROGRESS_40.md) · [60%](PROGRESS_60.md) · [80%](PROGRESS_80.md)
