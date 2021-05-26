//
//  DestinationCollectionViewCell.swift
//  AirbnbApp
//
//  Created by Song on 2021/05/20.
//

import UIKit

class DestinationCollectionViewCell: UICollectionViewCell {
    enum Constant {
        static let imageCornerRadius: CGFloat = 10.0
        static let imageBorderWidth: CGFloat = 1.0
        static let defaultImageName: String = "mappin.circle.fill"
    }
    
    static let reuseIdentifier = String(describing: DestinationCollectionViewCell.self)
    @IBOutlet weak var destinationImageView: UIImageView!
    @IBOutlet weak var destinationNameLabel: UILabel!
    @IBOutlet weak var drivingTimeLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
        destinationImageView.layer.masksToBounds = true
        destinationImageView.layer.cornerRadius = Constant.imageCornerRadius
        setDefaultImage()
    }
    
    static func nib() -> UINib {
        let nib = UINib(nibName: reuseIdentifier, bundle: nil)
        return nib
    }
    
    func fill(with viewModel: DestinationViewModel) {
        destinationNameLabel.text = viewModel.name
        drivingTimeLabel.text = viewModel.drivingTime
    }
    
    private func setDefaultImage() {
        destinationImageView.layer.borderWidth = Constant.imageBorderWidth
        destinationImageView.layer.borderColor = #colorLiteral(red: 0.5098039216, green: 0.5098039216, blue: 0.5098039216, alpha: 1)
        destinationImageView.backgroundColor = #colorLiteral(red: 0.9607843137, green: 0.9607843137, blue: 0.968627451, alpha: 1)
        destinationImageView.contentMode = .center
        let configuration = UIImage.SymbolConfiguration(scale: .large)
        let image = UIImage(systemName: Constant.defaultImageName, withConfiguration: configuration)
        destinationImageView.tintColor = #colorLiteral(red: 0.5098039216, green: 0.5098039216, blue: 0.5098039216, alpha: 1)
        destinationImageView.image = image
    }
}