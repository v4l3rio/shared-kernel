const config = require('semantic-release-preconfigured-conventional-commits')

const publishCommands = `
git tag -a -f \${nextRelease.version} \${nextRelease.version} -F CHANGELOG.md || exit 2
git push --force origin \${nextRelease.version} || exit 3
echo "release_status=released" >> $GITHUB_ENV
echo "CONTAINER_VERSION="\${nextRelease.version} >> $GITHUB_ENV
`
const releaseBranches = ["main"]

config.branches = releaseBranches

config.plugins.push(
    // Custom release commands
    ["@semantic-release/exec", {
        "publishCmd": publishCommands,
    }],
    "@semantic-release/github",
    "@semantic-release/git",
)

module.exports = config