## [0.9.0](https://github.com/position-pal/shared-kernel/compare/0.8.0...0.9.0) (2024-11-17)

### Features

* added event interface ([734f113](https://github.com/position-pal/shared-kernel/commit/734f113cf3a5990c68da9a6677760f3167547633))

## [0.8.0](https://github.com/position-pal/shared-kernel/compare/0.7.0...0.8.0) (2024-11-17)

### Features

* create two distinct commands `GroupWisePushNotification` and `CoMembersPushNotification` for notifications ([1e2829a](https://github.com/position-pal/shared-kernel/commit/1e2829a053e057e50d0bd026860966543fe4dc36))

## [0.7.0](https://github.com/position-pal/shared-kernel/compare/0.6.0...0.7.0) (2024-11-14)

### Features

* **domain:** add notifications commands and entities ([4bac0e8](https://github.com/position-pal/shared-kernel/commit/4bac0e8ceba3e98fa48812406da50cd0411ef577))
* **presentation:** add notification schemas and de/serializers ([eb5d6c6](https://github.com/position-pal/shared-kernel/commit/eb5d6c628bd24e1da82d0a9afbc126896ebcba87))

## [0.6.0](https://github.com/position-pal/shared-kernel/compare/0.5.0...0.6.0) (2024-11-13)

### Features

* added domain elements and interfaces ([44b9eff](https://github.com/position-pal/shared-kernel/commit/44b9eff767fe4dda5318b0ab4345fa0cc9226f59))

### Dependency updates

* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.115 ([#7](https://github.com/position-pal/shared-kernel/issues/7)) ([1f732cd](https://github.com/position-pal/shared-kernel/commit/1f732cdd6fb3228b6e8e6914e1b8bae9e0dfffe4))

### Bug Fixes

* solved ci problem with java 11 ([10af441](https://github.com/position-pal/shared-kernel/commit/10af44142b7f04ae9a4dbcb77165cfd6848fa808))

### Build and continuous integration

* do not fail javadoc generation because of linting warning ([e4b756e](https://github.com/position-pal/shared-kernel/commit/e4b756e566fc8a3fbad61ddc4413d2f9d09fa9ab))
* test javadoc and sourceJar generation ([ed4eddf](https://github.com/position-pal/shared-kernel/commit/ed4eddfb3551b2f11f797135a1e4aad3821d4f76))

### Refactoring

* apply java qa plugin ([a3b1167](https://github.com/position-pal/shared-kernel/commit/a3b11674d5fd353372b148f93de8c56c817069ab))

## [0.5.0](https://github.com/position-pal/shared-kernel/compare/0.4.0...0.5.0) (2024-11-12)

### Features

* message implementation ([be40e9d](https://github.com/position-pal/shared-kernel/commit/be40e9d05227eb61285437b6f920cb47150cb20a))

## [0.4.0](https://github.com/position-pal/shared-kernel/compare/0.3.1...0.4.0) (2024-11-09)

### Features

* groups event ([0facbda](https://github.com/position-pal/shared-kernel/commit/0facbdafc680f42abcbd9919ec10763e43e57228))

### Bug Fixes

* removed class from deserialization ([6630d8a](https://github.com/position-pal/shared-kernel/commit/6630d8ac6439b01c98e9336014590cc943b0da54))

### Tests

* added group events tests ([834b137](https://github.com/position-pal/shared-kernel/commit/834b137733b84038dc83cba362ecaab49c6acac9))

## [0.3.1](https://github.com/position-pal/shared-kernel/compare/0.3.0...0.3.1) (2024-11-07)

### Dependency updates

* **deps:** update plugin kotlin-qa to v0.69.0 ([1dd951e](https://github.com/position-pal/shared-kernel/commit/1dd951ea5a97b6e54cfd4ec0857fe0c5fa89cf18))

### Bug Fixes

* apply publication plugin on all submodules and rename package name ([c59d6a8](https://github.com/position-pal/shared-kernel/commit/c59d6a8f25634a301b54df9b1fb9d98faad6335c))

### General maintenance

* add author email and remove password from user ([e37dc00](https://github.com/position-pal/shared-kernel/commit/e37dc0015c7220eb777c79e84fc58f9792838a96))

## [0.3.0](https://github.com/position-pal/shared-kernel/compare/0.2.1...0.3.0) (2024-11-06)

### Features

* dry deployment on maven ([7b769ea](https://github.com/position-pal/shared-kernel/commit/7b769ea633b6a04356848b4c82688e604e7f37e0))

### Bug Fixes

* add setup of code and java in dry-deployment ([f4d3352](https://github.com/position-pal/shared-kernel/commit/f4d3352b18b9519f342c24e2242b75ddcf9f20d9))
* add sign env in dry-deployment ([2ec1ac3](https://github.com/position-pal/shared-kernel/commit/2ec1ac3eb19953f765203da09a36d6a01d24a563))

### Revert previous changes

* back to github release ([df809e9](https://github.com/position-pal/shared-kernel/commit/df809e938f629138851a803538aa7387e28d29a6))

## [0.2.0](https://github.com/position-pal/shared-kernel/compare/0.1.1...0.2.0) (2024-11-05)

### Features

* add automatic release to github packages ([cde02eb](https://github.com/position-pal/shared-kernel/commit/cde02eb45020f2cfe33d4149fdc68b0f017c8560))

### Bug Fixes

* move tests inside correct package ([880eb24](https://github.com/position-pal/shared-kernel/commit/880eb244b08a2617f0aa84225e990f760917d77e))

## [0.1.1](https://github.com/position-pal/shared-kernel/compare/0.1.0...0.1.1) (2024-11-05)

### Bug Fixes

* implement interface serializer ([4912bc9](https://github.com/position-pal/shared-kernel/commit/4912bc9c42486bf285e54fb018a790598be4e4a8))
