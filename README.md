# Water Quality Monitor

سامانه سبک ثبت و تحلیل داده‌های کیفیت آب — پروژه تیم Nexora.

## وضعیت فعلی: 60%

### قابلیت‌های پیاده‌سازی‌شده
- ثبت pH، دما، DO و EC همراه محل، زمان و توضیحات
- داشبورد و آخرین اندازه‌گیری‌ها
- صفحه سوابق، جستجو و فیلتر بازه زمانی
- حذف رکورد
- محاسبه میانگین شاخص‌ها و آمار خلاصه
- نمودار روند pH، دما، DO و EC با Chart.js

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
- [ ] 80% — Thresholds, alerts and Excel export
- [ ] 100% — Testing, documentation and delivery

گزارش‌ها: [20%](PROGRESS_20.md) · [40%](PROGRESS_40.md) · [60%](PROGRESS_60.md)
