require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "react-native-twilio-video"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.homepage     = package["homepage"]
  s.license      = package["license"]
  s.authors      = package["author"]

  s.platforms    = { :ios => "12.2" }
  s.source       = { :git => "https://github.com/kuanyshevaidos/react-native-twilio-video.git", :tag => "#{s.version}" }


  s.source_files = "ios/**/*.{h,m,mm,swift}"


  s.dependency "React"
  s.dependency 'TwilioVideo', '~> 5.5'
  s.dependency 'DictionaryCoding', '~> 1.0'
end
